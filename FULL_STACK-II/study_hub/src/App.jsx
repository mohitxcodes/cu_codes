import { Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Login from './components/Login';
import TaskManager from './components/TaskManager';
import Profile from './components/Profile';
import { StudentProvider } from './StudentContext';
import './App.css';

function App() {
  return (
    <StudentProvider>
      <div className="App">
        <Navbar />
        <hr />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/tasks" element={<TaskManager />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </div>
    </StudentProvider>
  );
}

export default App;
