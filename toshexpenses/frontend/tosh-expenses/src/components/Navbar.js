import React from "react";
import { Link } from 'react-router-dom';
import '../styles/Navbar.css';

function Navbar() {
    return (
        <nav className="navbar">
            <h1>Tosh Expenses</h1>
            <div>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/dashboard">Dashboard</Link>
                    </li>
                </ul>
            </div>
            {/*<div className="links">*/}
            {/*    <Link to="/">Home</Link>*/}
            {/*    <Link to="/add-expense">Add Expense</Link>*/}
            {/*    <Link to="/dashboard">Dashboard</Link>*/}
            {/*</div>*/}
        </nav>
    );
}

export default Navbar;