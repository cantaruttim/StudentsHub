import React, { useState } from 'react';
import './style.css';

function Login() {
  const [registrationNumber, setRegistrationNumber] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aqui você pode adicionar lógica de autenticação ou chamada para uma API
    console.log('Matrícula:', registrationNumber);
    console.log('Senha:', password);
  };

  return (
    <div className="container">
      <header>
        <h1>Login</h1>
      </header>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="registrationNumber">Matrícula:</label>
          <input
            type="text"
            id="registrationNumber"
            name="registrationNumber"
            value={registrationNumber}
            onChange={(e) => setRegistrationNumber(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="password">Senha:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>

        <div className="buttons">
          <button type="submit" className="submit-btn">Entrar</button>
        </div>
      </form>
    </div>
  );
}

export default Login;
