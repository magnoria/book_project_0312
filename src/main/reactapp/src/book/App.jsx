import { BrowserRouter, Routes, Route } from "react-router-dom";
import Book  from './book';
import Update  from './Update';
import Review from './PepleReview';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Book />} />
        <Route path="/book" element={<Book />} />
        <Route path="/update" element={<Update />} />
        <Route path="/review" element={<Review />}/>
        
      </Routes>
    </BrowserRouter>
  );
}

export default App;