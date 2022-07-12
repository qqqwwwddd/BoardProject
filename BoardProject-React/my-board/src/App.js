import logo from "./logo.svg";
import "./App.css";
import { Link } from "react-router-dom";
import BoardList from "./pages/Board/BoardList";

function App() {
    return (
        <div>
            <h1>게시판</h1>
            <div>
                <Link to="/add">
                    <span>글쓰기</span>
                </Link>
            </div>
            <BoardList />
        </div>
    );
}

export default App;
