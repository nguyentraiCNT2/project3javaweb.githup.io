import React from 'react';

const Role = ({ role, onEdit, onDelete }) => {
  return (
    <div>
      <button onClick={() => onEdit(role)}>Edit</button>
      <button onClick={() => onDelete(role.roleid)}>Delete</button>
    </div>
  );
};

export default Role;
