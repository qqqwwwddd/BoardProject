import React, { useState } from "react";
import { BoardList } from "./BoardList";
import { addBoard, boardAdd } from "../../api/boardAPI";
import { Link } from "react-router-dom";

function AddBoard() {
    return (
        <div>
            <h1>게시판 등록</h1>
            <div>
                <h2>제목</h2>
                <input
                    type="text"
                    id="boardTitle"
                    placeholder="제목을 입력하세요"
                />
            </div>
            <div>
                <h2>내용</h2>
                <input
                    type="text"
                    id="boardContent"
                    placeholder="내용을 입력하세요"
                />
            </div>
            <div>
                <h2>작성자</h2>
                <input
                    type="text"
                    id="user"
                    placeholder="이메일을 입력하세요"
                />
            </div>
            <a href="/">
                <button
                    onClick={() => {
                        const boardTitle =
                            document.getElementById("boardTitle").value;
                        const boardContent =
                            document.getElementById("boardContent").value;
                        const user = document.getElementById("user").value;
                        const data = {
                            boardTitle: boardTitle,
                            boardContent: boardContent,
                            user: { userEmail: user },
                        };
                        addBoard(data);
                    }}
                >
                    등록
                </button>
            </a>
        </div>
    );
}

export default AddBoard;
