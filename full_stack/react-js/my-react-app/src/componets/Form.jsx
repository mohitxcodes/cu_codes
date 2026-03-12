export default function Form() {
  return (
    <div className="flex flex-col gap-4 border-2 border-gray-200 bg-gray-100 p-4 rounded-lg">
      <h1 className="text-3xl font-bold  ">Login Your Account</h1>
      <input
        type="text"
        placeholder="Enter your name"
        className="border-2 border-gray-200 p-2 rounded-lg"
      />
      <input
        type="email"
        placeholder="Enter your email"
        className="border-2 border-gray-200 p-2 rounded-lg"
      />
      <input
        type="password"
        placeholder="Enter your password"
        className="border-2 border-gray-200 p-2 rounded-lg"
      />
      <button className="bg-blue-500 text-white p-2 rounded-lg cursor-pointer">
        Submit
      </button>
    </div>
  );
}
