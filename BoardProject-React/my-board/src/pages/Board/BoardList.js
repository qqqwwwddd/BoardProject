import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getBoardList } from "../../api/boardAPI";
import "../Board/board.css";

const getlist = (boardList, page, setPage) => {
    console.log(boardList);

    return (
        <div>
            <table border={1}>
                <thead>
                    <tr>
                        <td>
                            <h2>No.</h2>
                        </td>
                        <td>
                            <h2>제목</h2>
                        </td>
                        <td>
                            <h2>작성자</h2>
                        </td>
                        <td>
                            <h2>등록일</h2>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    {boardList &&
                        boardList.dtoList &&
                        boardList.dtoList.map((board) => {
                            return (
                                <tr key={board.boardNo}>
                                    <td>{board.boardNo}</td>
                                    <td>
                                        <Link to={`/board/${board.boardNo}`}>
                                            {`${board.boardTitle}[${board.comments.length}]`}
                                        </Link>
                                    </td>
                                    <td>{board.user.userEmail}</td>
                                    <td>{board.regiDate}</td>
                                </tr>
                            );
                        })}
                </tbody>
            </table>
            {/* 페이징 */}
            <ul className="pagination">
                <li className="page_item">
                    <span onClick={() => setPage(page === 1 ? 1 : page - 1)}>
                        Previous
                    </span>
                </li>
                {boardList &&
                    boardList.pageList &&
                    boardList.pageList.map((page) => (
                        <li key={page} className="page_items">
                            <span
                                // key={page}
                                id={page}
                                onClick={(e) => {
                                    setPage(parseInt(e.target.id));
                                }}
                            >
                                {page}
                            </span>
                        </li>
                    ))}

                <li className="page_item">
                    <span
                        onClick={() =>
                            setPage(
                                page === boardList.pageList.length
                                    ? boardList.pageList.length
                                    : page + 1
                            )
                        }
                    >
                        Next
                    </span>
                </li>
            </ul>
        </div>
    );
};

function BoardList() {
    const [boardList, setBoardList] = useState([]);
    const [page, setPage] = useState(1);
    useEffect(() => {
        getBoardList(setBoardList, page);
    }, [page]);
    console.log(boardList);
    console.log(page);
    return <div>{getlist(boardList, page, setPage)}</div>;
    //  <div>{getlist({})}</div>;
}
export default BoardList;
