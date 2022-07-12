import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { deleteBoard, editBoard, getBoard } from "../../api/boardAPI";
import Comment from "../Comment/Comment";

function Board() {
    const [data, setData] = useState();
    const [check, setCheck] = useState(false);
    const boardNo = useParams().boardNo;
    console.log(boardNo);
    useEffect(() => {
        getBoard(setData, boardNo);
    }, []);
    return (
        <div>
            <h2>게시글</h2>
            <div>
                <h4>제목</h4>
                <input
                    type="text"
                    id="boardTitle"
                    placeholder="제목을 입력하세요"
                    defaultValue={data && data.boardTitle}
                />
            </div>
            <div>
                <h4>내용</h4>
                <input
                    type="text"
                    id="boardContent"
                    placeholder="내용을 입력하세요"
                    defaultValue={data && data.boardContent}
                />
            </div>
            <div>
                <h4>작성자</h4>
                <input
                    type="text"
                    id="user"
                    placeholder="이메일을 입력하세요"
                    value={data && data.user && data.user.userEmail}
                />
            </div>
            <div>
                <h4>등록일</h4>
                <input
                    type="text"
                    id="regiDate"
                    placeholder="등록일"
                    value={data && data.regiDate}
                />
            </div>
            <div>
                <h4>수정일</h4>
                <input
                    type="text"
                    id="modiDate"
                    placeholder="이메일을 입력하세요"
                    value={data && data.modiDate}
                />
            </div>

            <button
                onClick={() => {
                    setCheck(!check);
                }}
            >{`댓글[${data && data.comments && data.comments.length}]`}</button>
            <a href="/">
                <button>Home</button>
            </a>
            <button
                onClick={() => {
                    const boardTitle =
                        document.getElementById("boardTitle").value;
                    const boardContent =
                        document.getElementById("boardContent").value;
                    const user = document.getElementById("user").value;
                    const newdata = {
                        boardTitle: boardTitle,
                        boardContent: boardContent,
                        user: { userEmail: user },
                    };
                    editBoard(newdata, boardNo);
                }}
            >
                수정
            </button>
            <a href="/">
                <button
                    onClick={() => {
                        deleteBoard(boardNo);
                    }}
                >
                    삭제
                </button>
            </a>
            {check ? <Comment boardNo={boardNo} /> : null}
        </div>
    );
}

export default Board;
