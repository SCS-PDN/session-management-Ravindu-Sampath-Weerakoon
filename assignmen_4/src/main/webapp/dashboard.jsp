<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Course Registration Dashboard</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <style>
    .dashboard-glass {
      background: rgba(30, 41, 59, 0.3); /* Darker background with some transparency */
      backdrop-filter: blur(12px);
      -webkit-backdrop-filter: blur(12px);
      border-radius: 1rem;
      border: 1px solid rgba(55, 65, 81, 0.5); /* Darker border */
      box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3); /* More pronounced dark shadow */
      padding: 2rem;
    }

    .dashboard-glass-text {
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
    }
  </style>
</head>
<body class="bg-gray-900 min-h-screen py-4">
<nav class="bg-gray-800 bg-opacity-50 backdrop-filter backdrop-blur-md text-white py-2 px-4 sticky top-0 z-10">
  <div class="container mx-auto flex justify-between items-center">
    <h1 class="text-xl font-semibold dashboard-glass-text">Welcome, ${username}!</h1>
    <a href="LogoutServlet" class="bg-red-500 hover:bg-red-600 text-white font-semibold py-2 px-4 rounded-md text-sm dashboard-glass-text focus:outline-none focus:shadow-outline flex items-center">
      <i class="fas fa-sign-out-alt mr-2"></i> Logout
    </a>
  </div>
</nav>

<div class="container mx-auto p-4 mt-6 flex space-x-4">
  <div class="dashboard-glass rounded-xl p-8 w-1/2">
    <h2 class="text-xl font-semibold text-gray-300 mb-3 dashboard-glass-text">Available Courses</h2>
    <c:forEach var="course" items="${courses}">
      <div class="flex items-center justify-between py-2">
        <span class="text-gray-400 dashboard-glass-text">${course.id} - ${course.name} - ${course.instructor}</span>
        <a href="EnrollServlet?courseId=${course.id}" class="bg-green-500 hover:bg-green-600 text-white font-semibold py-2 px-4 rounded-md text-sm dashboard-glass-text focus:outline-none focus:shadow-outline">Enroll</a>
      </div>
    </c:forEach>
  </div>

  <div class="dashboard-glass rounded-xl p-8 w-1/2">
    <h2 class="text-xl font-semibold text-gray-300 mb-3 dashboard-glass-text">Your Enrolled Courses</h2>
    <c:forEach var="course" items="${enrolledCourses}">
      <p class="text-gray-400 py-1 dashboard-glass-text">${course.name} (${course.id})</p>
    </c:forEach>
  </div>
</div>
</body>
</html>