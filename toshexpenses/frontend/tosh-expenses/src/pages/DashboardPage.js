import React, { useState, useEffect } from "react";
import axios from "axios";

const Dashboard = () => {
    const [dashboardData, setDashboardData] = useState({
        totalUsers: '',
        totalExpenses: '',
        categorySummaries: '',
        totalAmount: '',
    });

    useEffect(() => {
        const fetchDashboardData = async () => {
            try {
                const response = await axios.get(`${process.env.REACT_APP_BACKEND_URL || 'http://localhost:8080'}/api/dashboard`);
                setDashboardData(response.data);
            } catch (error) {
                console.error("Failed to fetch dashboard data:", error);
            }
        };

        fetchDashboardData();
    }, []);

    if (!dashboardData) {
        return <p>Loading dashboard...</p>;
    }

    return (
        <div className="dashboard">
            <h2>Dashboard</h2>
            <p>Total Users: {dashboardData.totalUsers}</p>
            <p>Total Expenses: {dashboardData.totalExpenses}</p>
            <h3>Expenses by Category:</h3>
            {/*<ul>*/}
            {/*    {dashboardData.categorySummaries.map((summary) => (*/}
            {/*        <li key={summary.category}>*/}
            {/*            {summary.category}: {summary.totalAmount}*/}
            {/*        </li>*/}
            {/*    ))}*/}
            {/*</ul>*/}
        </div>
    );
};

export default Dashboard;
