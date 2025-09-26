import React, { useState } from 'react';
import './forms.css';

function FormsActivities() {
  // Estados controlados para os inputs
  const [email, setEmail] = useState('');
  const [nome, setNome] = useState('');
  const [matricula, setMatricula] = useState('');
  const [modulo, setModulo] = useState('');

  // Dados dinâmicos simulados
  const tituloPrincipal = 'Maturidade Espiritual';
  const autor = 'Pra. Laura Valente';
  const subtitulo = 'Atividade - Módulo 2: Maturidade Espiritual';

  // Simulação de envio
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log({ email, nome, matricula, modulo });

    // Você pode fazer um POST aqui com fetch ou axios, por exemplo
    // fetch('/api/responder', { method: 'POST', body: JSON.stringify(...) })
  };

  return (
    <div className="container">
      <header>
        <h1>{tituloPrincipal}</h1>
        <p className="author">{autor}</p>
      </header>

      <h2>{subtitulo}</h2>

      <div className="instructions">
        <p>Graça e paz, Aluno(a)!</p>
        <p>
          Segue a atividade de hoje, lembrando que a atividade vale 1 ponto e o link sairá do ar sempre no dia seguinte às 23h.
        </p>
        <p>
          No amor de Cristo Jesus,<br />
          ADAI College
        </p>
      </div>

      <p>
        <span className="required">*</span> Indica questão obrigatória
      </p>
      <br />

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="email">Email <span className="required">*</span></label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Seu endereço de email"
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className="form-group">
          <label htmlFor="name">Nome completo <span className="required">*</span></label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Seu nome completo"
            required
            value={nome}
            onChange={(e) => setNome(e.target.value)}
          />
        </div>

        <div className="form-group">
          <label htmlFor="registrationNumber">Matrícula <span className="required">*</span></label>
          <input
            type="text"
            id="registrationNumber"
            name="registrationNumber"
            placeholder="Matrícula"
            required
            value={matricula}
            onChange={(e) => setMatricula(e.target.value)}
          />
        </div>

        <div className="form-group">
          <label htmlFor="module">Módulo <span className="required">*</span></label>
          <input
            type="text"
            id="module"
            name="module"
            placeholder="Módulo"
            required
            value={modulo}
            onChange={(e) => setModulo(e.target.value)}
          />
        </div>

        <div className="buttons">
          <button type="submit" className="submit-btn">Enviar</button>
        </div>
      </form>
    </div>
  );
}

export default FormsActivities;

