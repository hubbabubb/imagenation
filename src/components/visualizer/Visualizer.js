import {Container} from "react-bootstrap";
import {Card} from "@material-ui/core";
import Display from "./Display";
import './Visualizer.css';
import Input from "./Input";

export default function Visualizer() {
    return <Container>
        <Input/>
        <Card className="displayCard">
            <Display/>
        </Card>
    </Container>
}