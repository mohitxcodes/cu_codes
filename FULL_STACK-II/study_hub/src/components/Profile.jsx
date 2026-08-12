import { useUser } from '../StudentContext';
import { Navigate } from 'react-router-dom';

export default function Profile() {
  const { student, isLoggedIn } = useUser();

  if (!isLoggedIn) {
    return <Navigate to="/login" replace />;
  }

  return (
    <div>
      <h2>Student Details</h2>
      <p>Name: {student.name}</p>
      <p>Email: {student.email}</p>
      <p>Year: {student.year}</p>
    </div>
  );
}
