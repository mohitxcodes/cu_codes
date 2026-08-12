import { NavLink, useNavigate } from 'react-router-dom';
import { useUser } from '../StudentContext';

export default function Navbar() {
  const { isLoggedIn, logout } = useUser();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <nav>
      <NavLink to="/">Home</NavLink>{" | "}
      {!isLoggedIn && <NavLink to="/login">Login</NavLink>}
      {!isLoggedIn && " | "}
      {isLoggedIn && <NavLink to="/tasks">Tasks</NavLink>}
      {isLoggedIn && " | "}
      {isLoggedIn && <NavLink to="/profile">Profile</NavLink>}
      {isLoggedIn && " | "}
      {isLoggedIn && <button onClick={handleLogout}>Logout</button>}
    </nav>
  );
}