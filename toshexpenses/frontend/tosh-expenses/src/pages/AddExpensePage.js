import React, { useState } from 'react';
import axios from 'axios';
import '../styles/AddExpensePage.css';
import {useLocation} from "react-router-dom";

const AddExpensePage = () => {
    const [expense, setExpense] = useState({
        category: '',
        description: '',
        amount: '',
    });
    const [message, setMessage] = useState(null); // For success or error messages

    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const userId = queryParams.get('userId');

    // Handle input changes
    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setExpense({ ...expense, [name]: value });
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(
                `${process.env.REACT_APP_BACKEND_URL || 'http://localhost:8080'}/api/expenses/create?userId=${userId}`,
                expense
            );
            setMessage({ type: 'success', text: 'Expense added successfully!' });
            console.log('Expense added successfully: ', response.data);
            // Optionally clear the form
            setExpense({ category: '', description: '', amount: '' });
        } catch (error) {
            setMessage({ type: 'error', text: 'Failed to add expense. Please try again.' });
            console.error('Error adding expense: ', error);
        }
    };

    return (
        <div className="add-expense-container">
            <h2>Add Expense</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Category:
                    <input
                        type="text"
                        name="category"
                        value={expense.category}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <label>
                    Description:
                    <input
                        type="text"
                        name="description"
                        value={expense.description}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <label>
                    Amount:
                    <input
                        type="number"
                        name="amount"
                        value={expense.amount}
                        onChange={handleInputChange}
                        required
                    />
                </label>
                <button type="submit">Submit</button>
            </form>
            {message && (
                <p className={`message ${message.type}`}>{message.text}</p>
            )}
        </div>
    );
};

export default AddExpensePage;
