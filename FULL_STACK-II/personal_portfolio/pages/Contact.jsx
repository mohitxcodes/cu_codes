import { useNavigate } from "react-router-dom"

function Contact() {
  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault()

    navigate("/")
  }

  return (
    <div style={{ padding: "30px" }}>
      <h1>Contact Us</h1>
      <p>Send us a message and we will get back to you.</p>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Name</label>
          <br />
          <input type="text" placeholder="Enter your name" />
        </div>

        <br />

        <div>
          <label>Email</label>
          <br />
          <input type="email" placeholder="Enter your email" />
        </div>

        <br />

        <div>
          <label>Message</label>
          <br />
          <textarea placeholder="Enter your message"></textarea>
        </div>

        <br />

        <button type="submit">
          Send Message
        </button>
      </form>
    </div>
  )
}

export default Contact