import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import { Link } from "react-router-dom";
import BoardList from "./pages/Board/BoardList";
import "./pages/Board/board.css";
function App() {
    return (
        <div className="container">
            <header>
                <a href="/">
                    <span className="header">BOARD</span>
                </a>
                <div className="header_items">
                    <a href="/add">
                        <span>글쓰기</span>
                    </a>
                    <a href="/">
                        <span>Login</span>
                    </a>
                </div>
            </header>
            <hr />
            <BoardList />
        </div>
    );
}

export default App;
