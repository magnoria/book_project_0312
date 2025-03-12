import { BrowserRouter, Routes, Route } from "react-router-dom";
import Book  from './book';
import Update  from './Update';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Book />} />
        <Route path="/book" element={<Book />} />
        <Route path="/update" element={<Update />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;