import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import WelcomePage from "./pages/WelcomePage";
import DashboardPage from "./pages/DashboardPage";
import AddExpensePage from "./pages/AddExpensePage";

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<WelcomePage />} />
            <Route path="/add-expense" element={<AddExpensePage />} />
          <Route path="/dashboard" element={<DashboardPage />} />
        </Routes>
      </Router>
  );
}

export default App;
