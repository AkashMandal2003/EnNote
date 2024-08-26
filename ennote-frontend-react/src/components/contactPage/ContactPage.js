import React, { useState } from "react";
import axios from "axios";
import toast, { Toaster } from "react-hot-toast";

const apiUrl = process.env.REACT_APP_API_URL;

const ContactPage = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    message: ""
  });

  const onChangeHandler = (e) => {
    setFormData({
      ...formData,
      [e.target.id]: e.target.value
    });
  };

  const onSubmitHandler = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post(`${apiUrl}/api/contact/send`, formData);
      toast.success("Message sent successfully!");
      setFormData({ name: "", email: "", message: "" }); // Clear the form
    } catch (error) {
      toast.error("There was an error sending the email.");
      console.error("Error:", error);
    }
  };

  return (
    <div className="flex items-center justify-center min-h-[calc(100vh-74px)] bg-gray-100">
      <div className="bg-white p-8 rounded-lg shadow-lg max-w-md w-full mx-4 text-center">
        <h1 className="text-3xl font-bold mb-4">Contact Us</h1>
        <p className="text-gray-600 mb-4">
          We'd love to hear from you! If you have any questions or feedback,
          feel free to reach out to us.
        </p>
        <form onSubmit={onSubmitHandler} className="space-y-4">
          <div>
            <label
              className="block text-left text-gray-700 mb-2"
              htmlFor="name"
            >
              Name
            </label>
            <input
              type="text"
              id="name"
              value={formData.name}
              onChange={onChangeHandler}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>
          <div>
            <label
              className="block text-left text-gray-700 mb-2"
              htmlFor="email"
            >
              Email
            </label>
            <input
              type="email"
              id="email"
              value={formData.email}
              onChange={onChangeHandler}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
          </div>
          <div>
            <label
              className="block text-left text-gray-700 mb-2"
              htmlFor="message"
            >
              Message
            </label>
            <textarea
              id="message"
              value={formData.message}
              onChange={onChangeHandler}
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            ></textarea>
          </div>
          <button
            type="submit"
            className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
          >
            Send Message
          </button>
        </form>
      </div>
      <Toaster
        position="bottom-center" 
        reverseOrder={false} 
      />
    </div>
  );
};

export default ContactPage;
