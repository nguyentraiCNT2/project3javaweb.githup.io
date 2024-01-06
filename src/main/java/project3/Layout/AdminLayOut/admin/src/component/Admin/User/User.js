// src/components/User.js
import React from 'react';

const User = ({ user, onEdit, onDelete }) => {
  return (
    <div>
      <button onClick={() => onEdit(user)}>Edit</button>
      <button onClick={() => onDelete(user.userid)}>Delete</button>
    </div>
  );
};

export default User;
