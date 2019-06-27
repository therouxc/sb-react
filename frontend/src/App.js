import React from 'react';
import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';
import ToDo from './components/ToDo';

function App() {
  return (
    <div className="App">
      <NavBar/>
      <ToDo/>
    </div>
  );
}

export default App;
