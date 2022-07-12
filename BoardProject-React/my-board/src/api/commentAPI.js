import axios from "axios";

export function addComment(comment, setCheck, check) {
    const url = "http://localhost:8080/comment";
    axios
        .post(url, comment)
        .then((response) => {
            console.log(response.data);
            setCheck(!check);
        })
        .catch((error) => console.log(error));
}
export function allComments(setdata, boardNo) {
    const url = `http://localhost:8080/comment/${boardNo}`;
    axios
        .get(url)
        .then((response) => setdata(response.data))
        .catch((error) => console.log(error));
}

export function deleteComment(commentNo, setCheck, check) {
    const url = `http://localhost:8080/comment/${commentNo}`;
    axios
        .delete(url)
        .then(() => setCheck(!check))
        .catch((error) => console.log(error));
}

export function updateComment(newData, setCheck, check) {
    const url = `http://localhost:8080/comment/${newData.commentNo}`;
    axios
        .put(url, newData)
        .then(() => setCheck(!check))
        .catch((error) => console.log(error));
}
