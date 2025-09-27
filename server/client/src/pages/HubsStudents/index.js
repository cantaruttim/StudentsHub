import React from 'react';
import { Link } from 'react-router-dom';
import { FiPower } from 'react-icons/fi';
import './styles.css';

export default function StudentHub() {
  return (
    <div className="student-hub-page">
      <header className="top-menu">
        <span>
          Bem-vindo <strong>Matheus</strong> ao Hub do Aluno
        </span>
        <Link className="button" to="/activity/new">
          Nova Atividade
        </Link>
        <button type="button">
          <FiPower size={24} color="#000000" />
        </button>
      </header>
    </div>
  );
}
