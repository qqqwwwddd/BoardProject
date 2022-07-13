import { useState } from "react";
import { deleteComment, updateComment } from "../../api/commentAPI";
import "bootstrap/dist/css/bootstrap.min.css";
import { Form } from "react-bootstrap";

function CommentList({ comment, setCheck, check }) {
    const [update, setUpdate] = useState(true);
    // console.log(comment);
    return (
        <div className="container">
            <Form>
                <div>
                    <span>댓글 작성자 : </span>
                    <span id="commenter">{comment.commenter}</span>
                </div>
                <div>
                    <span>댓글 내용 : </span>
                    {update ? (
                        <span id="commentContent">
                            {comment.commentContent}
                        </span>
                    ) : (
                        <input
                            type="text"
                            id="newContent"
                            defaultValue={comment.commentContent}
                        />
                    )}
                </div>
                <button
                    onClick={() => {
                        if (!update) {
                            const newContent =
                                document.getElementById("newContent").value;
                            const newData = {
                                commentNo: comment.commentNo,
                                commentContent: newContent,
                                commenter: comment.commenter,
                                board: { boardNo: comment.board.boardNo },
                            };
                            updateComment(newData, setCheck, check);
                        }
                        setUpdate(!update);
                    }}
                >
                    수정
                </button>
                <button
                    onClick={() => {
                        deleteComment(comment.commentNo, setCheck, check);
                    }}
                >
                    삭제
                </button>
            </Form>
        </div>
    );
}

export default CommentList;
