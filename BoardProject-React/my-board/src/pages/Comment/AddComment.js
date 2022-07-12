import { useState } from "react";
import { useParams } from "react-router-dom";
import { addComment } from "../../api/commentAPI";

function AddCommentForm({ setCheck, check }) {
    const boardNo = useParams().boardNo;
    return (
        <div>
            <div>
                <span>댓글 작성자 : </span>
                <input type="text" id="commenter" />
            </div>
            <div>
                <span>댓글 내용 : </span>
                <input type="text" id="commentContent" />
            </div>
            <button
                onClick={() => {
                    const commenter =
                        document.getElementById("commenter").value;
                    const commentContent =
                        document.getElementById("commentContent").value;
                    const comment = {
                        commenter: commenter,
                        commentContent: commentContent,
                        board: { boardNo: boardNo },
                    };
                    addComment(comment, setCheck, check);
                }}
            >
                작성
            </button>
        </div>
    );
}

export default AddCommentForm;
