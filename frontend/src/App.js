import './App.css';
import {Container,  Row} from "react-bootstrap";
import Visualizer from "./components/visualizer/Visualizer";

function App() {
    return <div className="App">
        <Container>
            <Row>
                <Visualizer />
            </Row>
        </Container>
    </div>
}

export default App;
