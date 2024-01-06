import React from 'react';

const ViewRolePage = ({ role, onCancel }) => {
  return (
    <div>
      <h2>Role Details</h2>
      <div>
        <strong>RoleID:</strong> {role.roleid}
      </div>
      <div>
        <strong>Rolename:</strong> {role.rolename}
      </div>
      <div>
        <strong>Status:</strong> {role.status ? 'Active' : 'Inactive'}
      </div>
      <div className="mt-3">
        <button className="btn btn-secondary" onClick={onCancel}>
          Close
        </button>
      </div>
    </div>
  );
};

export default ViewRolePage;
