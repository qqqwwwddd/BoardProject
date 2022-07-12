import axios from "axios";

// 글쓰기
export const addBoard = (data) => {
    const url = "http://localhost:8080/board";

    console.log(data);
    axios.post(url, data).catch((error) => console.log(error));
};

// 전체글
export const getBoardList = (setBoardList, page) => {
    const url = `http://localhost:8080/boardList?page=${page}`;

    axios
        .get(url)
        .then((response) => setBoardList(response.data))
        .catch((error) => console.log(error));
};

// 게시글보기
export const getBoard = (setData, boardNo) => {
    const url = "http://localhost:8080/board/" + boardNo;
    axios
        .get(url)
        .then((response) => setData(response.data))
        .catch((error) => console.log(error));
};

// 게시글 수정
export const editBoard = (newdata, boardNo) => {
    const url = "http://localhost:8080/board/" + boardNo;
    axios
        .put(url, newdata)
        .then(() => alert("수정완료"))
        .catch((error) => console.log(error));
};

export const deleteBoard = (boardNo) => {
    const url = "http://localhost:8080/board/" + boardNo;
    axios.delete(url, boardNo).catch((error) => console.log(error));
};
