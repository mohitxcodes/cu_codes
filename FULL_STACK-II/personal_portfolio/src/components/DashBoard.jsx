import { Outlet, useNavigate } from "react-router-dom"

function DashBoard() {
  const navigate = useNavigate()

  return (
    <div style={{ padding: "30px" }}>
      <h1>Dashboard</h1>
      <p>Welcome to your personal dashboard.</p>

      <div style={{ margin: "20px 0" }}>
        <button onClick={() => navigate("profile")}>
          Profile
        </button>

        <button
          onClick={() => navigate("settings")}
          style={{ marginLeft: "10px" }}
        >
          Settings
        </button>

        <button
          onClick={() => navigate(-1)}
          style={{ marginLeft: "10px" }}
        >
          Back
        </button>
      </div>

      <hr />

      <Outlet />
    </div>
  )
}

export default DashBoard