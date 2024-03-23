
import { Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './Componenets/HomePage/HomePage';
import Authentication from './Componenets/Authentication/Authentication';

function App() {
  return (
    <div className="">
      
      <Routes>
        <Route path="/" element={true?<HomePage/>:<Authentication/>}>

        </Route>
      </Routes>

    </div>
  );
}

export default App;
