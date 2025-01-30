import React, { useRef, useEffect } from 'react';
import { Bar } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';

// Register required components
ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const DashboardPage = () => {
    const chartRef = useRef(null); // Reference to the chart instance

    //dummy data
    const data = {
        labels: ['January', 'February', 'March', 'April', 'May'], // Update dynamically
        datasets: [
            {
                label: 'Your Expenses',
                data: [400, 500, 450, 600, 700], // Will be replaced with API data
                backgroundColor: 'rgba(0, 51, 102, 0.7)',
            },
        ],
    };

    // Ensure clean up when the component unmounts by destroying the previous canvas
    useEffect(() => {
        return () => {
            // Destroy the chart instance if it exists
            if (chartRef.current) {
                chartRef.current.destroy();
            }
        };
    }, []);

    return (
        <div>
            <h2>Dashboard</h2>
            <Bar
                data={data}
                ref={chartRef}
                options={{
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: 'Monthly Expense Comparison',
                        },
                    },
                }}
            />
        </div>
    );
};

export default DashboardPage;
