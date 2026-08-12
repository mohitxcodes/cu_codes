import { createContext, useContext, useState } from 'react';

const StudentContext = createContext();

export function StudentProvider({ children }) {
  const [student] = useState({
    name: "Priya Nair",
    email: "priya@gmail.com",
    year: "3rd Year",
  });
  
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = () => setIsLoggedIn(true);
  const logout = () => setIsLoggedIn(false);

  return (
    <StudentContext.Provider value={{ student, isLoggedIn, login, logout }}>
      {children}
    </StudentContext.Provider>
  );
}

export function useUser() {
  return useContext(StudentContext);
}
