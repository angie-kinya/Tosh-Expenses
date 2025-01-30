import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import '../styles/WelcomePage.css';

function WelcomePage() {
    const [users, setUsers] = useState([]); // Initialize as an empty array

    useEffect(() => {
        console.log("useEffect triggered");

        // Fetch users from the backend
        const fetchUsers = async () => {
            try {
                console.log("Fetching users...");
                const response = await fetch('http://localhost:8080/api/users');
                const data = await response.json();
                console.log(data);
                setUsers(data);
            } catch (error) {
                console.error("Error fetching users:", error);
            }
        };

        fetchUsers();
    }, []);

    return (
        <div className="welcome">
            <h2>Welcome to Tosh Expenses</h2>
            <p>Select a family member to view or add expenses:</p>
            <div className="member-buttons">
                {users.length > 0 ? (
                    users.map((user) => (
                        <Link to={`/add-expense?userId=${user.id}`} key={user.id} className="btn">{user.username}</Link>
                    // <Link
                    //     key={user.id}
                    //       to={`/add-expense/${user.id}`}
                    //        className="btn"
                    //     >
                    //        {user.username}
                    // </Link>
                    ))
                ) : (
                    <p>Loading users...</p>
                )}
            </div>
        </div>
    );
}

export default WelcomePage;
