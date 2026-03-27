import { useEffect, useState } from "react";

// https://dummyjson.com/users/1

function App() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    const response = await fetch("https://dummyjson.com/users/1");
    const data = await response.json();
    setUser(data);
  };

  return (
    <div className="flex justify-center items-center h-screen">
      {user && (
        <div>
          <p>Name: {user.firstName}</p>
          <p>Email: {user.email}</p>
          <p>Phone: {user.phone}</p>
        </div>
      )}
    </div>
  );
}

export default App;
