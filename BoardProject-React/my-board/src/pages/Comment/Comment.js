import { useEffect, useState } from "react";
import { allComments } from "../../api/commentAPI";
import AddCommentForm from "./AddComment";
import CommentList from "./CommentList";

function Comment({ boardNo }) {
    const [data, setData] = useState([]);
    const [check, setCheck] = useState(false);
    useEffect(() => allComments(setData, boardNo), [check]);
    return (
        <div>
            <AddCommentForm setCheck={setCheck} check={check} />
            {data.map((comment) => (
                <CommentList
                    key={comment.commentNo}
                    comment={comment}
                    check={check}
                    setCheck={setCheck}
                />
            ))}
        </div>
    );
}
export default Comment;
