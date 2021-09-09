import {Col, Container, Row} from "react-bootstrap";
import {Card, makeStyles} from "@material-ui/core";
import Display from "./Display";
import './Visualizer.css';
import Input from "./Input";
import React, {useEffect, useState} from "react";
import Loading from "../Loading";

const useStyles = makeStyles({
    root: {
        backgroundColor: '#e5e2de',
        borderRadius: 20,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        width: 700,
        height: 700,
        marginTop: 50,
    },
});

export default function Visualizer() {
    const classes = useStyles();
    const [inputText, setInputText] = useState("");
    const [theme, setTheme] = useState({});
    const [themeIsLoading, setThemeLoading] = useState(true);

    useEffect(() => {
        setThemeLoading(true);
        fetch("http://localhost:9000/api/convert", {
            method: "POST",
            headers: {
                'Content-Type': 'text/plain'
            },
            body: inputText
        }).then((data) => data.json())
            .then((json) => {
                if (json.object === null) {
                    json.objectFile = "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 512 512\"><!-- Font Awesome Free 5.15.3 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License) --><path d=\"M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8z\"/></svg>";
                }
                setTheme(json);
                setTimeout(() => setThemeLoading(false), 250);
            })
            .catch((error) => {
                console.error(error);
            })
    }, [inputText])

    const changeInput = {setInputText};

    return <Container className='main'>
        <h1>ImageNation</h1>
        <Row>
            <Col>
                <Input methods={changeInput}/>
            </Col>
        </Row>
        <Row className="justify-content-center">
            <Col className="cardContainer">
                <Card className={classes.root}>
                    {themeIsLoading ? <Loading/> : <Display theme={theme}/>}
                </Card>
            </Col>
        </Row>
    </Container>
}