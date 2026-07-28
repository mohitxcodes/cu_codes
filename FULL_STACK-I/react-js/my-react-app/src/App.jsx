import { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";

function App() {
  const [data, setData] = useState("");

  const handleApiCall = async () => {
    const res = await axios.get("http://localhost:8080/api");
    const data = res.data;
    setData(data);
  };

  useEffect(() => {
    handleApiCall();
  }, []);

  return (
    <div className="flex flex-col justify-center items-center h-screen">
      <h1>Api Calling Test</h1>

      <div className="border border-black p-4">
        <p>{data}</p>
      </div>
    </div>
  );
}

export default App;
