import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { addComment } from "../../api/commentAPI";

function AddCommentForm({ setCheck, check }) {
    const boardNo = useParams().boardNo;
    return (
        <div className="container">
            <Form>
                <div>
                    <span>댓글 작성자 </span>
                    <input type="text" id="commenter" />
                </div>
                <div>
                    <span>댓글 내용 </span>
                    <input type="text" id="commentContent" />
                </div>

                <Button
                    className="button"
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
                        console.log(check);
                    }}
                >
                    댓글 등록
                </Button>
            </Form>
        </div>
    );
}

export default AddCommentForm;
