import { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, useParams } from "react-router-dom";
import { deleteBoard, editBoard, getBoard } from "../../api/boardAPI";
import Comment from "../Comment/Comment";
import { Button, Form } from "react-bootstrap";
import "./board.css";

function Board() {
    const [data, setData] = useState();
    const [check, setCheck] = useState(false);
    const boardNo = useParams().boardNo;
    console.log(boardNo);
    useEffect(() => {
        getBoard(setData, boardNo);
    }, []);
    return (
        <div className="container">
            <header>
                <a href={`/board/${boardNo}`}>
                    <span className="header">게시글</span>
                </a>
                <div className="header_items">
                    <a href="/add">
                        <span>글쓰기</span>
                    </a>
                    <a href="">
                        <span>Login</span>
                    </a>
                </div>
                <hr />
            </header>
            <div className="content">
                <Form>
                    <div>
                        <h5>제목</h5>
                        <input
                            type="text"
                            id="boardTitle"
                            placeholder="제목을 입력하세요"
                            defaultValue={data && data.boardTitle}
                        />
                    </div>
                    <div>
                        <h5>내용</h5>
                        <input
                            type="text"
                            id="boardContent"
                            placeholder="내용을 입력하세요"
                            defaultValue={data && data.boardContent}
                        />
                    </div>
                    <div>
                        <h5>작성자</h5>
                        <input
                            type="text"
                            id="user"
                            placeholder="이메일을 입력하세요"
                            value={data && data.user && data.user.userEmail}
                        />
                    </div>
                    <div>
                        <h5>등록일</h5>
                        <input
                            type="text"
                            id="regiDate"
                            placeholder="등록일"
                            value={data && data.regiDate}
                        />
                    </div>
                    <div>
                        <h5>수정일</h5>
                        <input
                            type="text"
                            id="modiDate"
                            placeholder="이메일을 입력하세요"
                            value={data && data.modiDate}
                        />
                    </div>
                    <br />
                    <div>
                        <Button
                            className="button"
                            onClick={() => {
                                setCheck(!check);
                            }}
                        >{`댓글[${
                            data && data.comments && data.comments.length
                        }]`}</Button>
                        <a href="/">
                            <Button>Home</Button>
                        </a>
                        <Button
                            onClick={() => {
                                const boardTitle =
                                    document.getElementById("boardTitle").value;
                                const boardContent =
                                    document.getElementById(
                                        "boardContent"
                                    ).value;
                                const user =
                                    document.getElementById("user").value;
                                const newdata = {
                                    boardTitle: boardTitle,
                                    boardContent: boardContent,
                                    user: { userEmail: user },
                                };
                                editBoard(newdata, boardNo);
                                setCheck(!check);
                            }}
                        >
                            수정
                        </Button>
                        <a href="/">
                            <Button
                                onClick={() => {
                                    deleteBoard(boardNo);
                                }}
                            >
                                삭제
                            </Button>
                        </a>
                    </div>
                </Form>
                {check ? <Comment boardNo={boardNo} /> : null}
            </div>
        </div>
    );
}

export default Board;
