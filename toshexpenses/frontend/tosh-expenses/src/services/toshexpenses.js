import axios from "axios";

const API_URL = 'http://localhost:8080/api/expenses';

export const getAllExpenses = async () => axios.get(API_URL);
export const addExpense = async userId => axios.post(`${API_URL}/create/${userId}`);
export const getExpensesByUserId = async userId => axios.get(`${API_URL}/view-expenses/${userId}`);
export const getUser = async userId => axios.get(`${API_URL}/users/${userId}`);