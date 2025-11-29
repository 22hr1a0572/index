JAVASCRIPT
'''
// SUBJECT-WISE QUESTIONS
const quizData = {
    html: [
        { q: "HTML stands for?", a: ["Hyper Text Markup Language", "Hyperlinks Text Machine Language", "HighText Machine Language"], correct: 0 },
        { q: "Which tag creates a paragraph?", a: ["<p>", "<h1>", "<div>"], correct: 0 },
        { q: "HTML is a ___ language", a: ["Programming", "Markup", "Database"], correct: 1 }
    ],

    css: [
        { q: "CSS stands for?", a: ["Color Style Sheet", "Cascading Style Sheets", "Creative Style System"], correct: 1 },
        { q: "Which symbol is used for IDs?", a: ["#", ".", "&"], correct: 0 },
        { q: "Which is used for text color?", a: ["color", "font-color", "text-color"], correct: 0 }
    ],

    js: [
        { q: "JS stands for?", a: ["JavaSource", "JavaScript", "JustScript"], correct: 1 },
        { q: "Which keyword declares a variable?", a: ["var", "int", "string"], correct: 0 },
        { q: "Which is an array?", a: ["{}", "[]", "()"], correct: 1 }
    ]
};

// VARIABLES
let questions = [];
let index = 0;
let score = 0;
let timer;
let timeLeft = 10;

// START QUIZ
function startQuiz(subject){
    document.getElementById("subjectBox").classList.add("hide");
    document.getElementById("quizBox").classList.remove("hide");

    document.getElementById("subjectTitle").innerText = subject.toUpperCase() + " Quiz";

    questions = quizData[subject];
    loadQuestion();
    startTimer();
}

// TIMER
function startTimer() {
    timeLeft = 10;
    document.getElementById("time").innerText = timeLeft;

    timer = setInterval(() => {
        timeLeft--;
        document.getElementById("time").innerText = timeLeft;

        if(timeLeft === 0){
            clearInterval(timer);
            nextQuestion();
        }
    }, 1000);
}

// LOAD QUESTION
function loadQuestion(){
    clearInterval(timer);
    startTimer();

    let q = questions[index];

    document.getElementById("questionText").innerText = q.q;

    let optionBox = document.getElementById("options");
    optionBox.innerHTML = "";

    q.a.forEach((option, i) => {
        let div = document.createElement("div");
        div.classList.add("option");
        div.innerText = option;
        div.onclick = () => selectOption(i);
        optionBox.appendChild(div);
    });

    document.getElementById("nextBtn").classList.add("hide");
}

// OPTION SELECT
function selectOption(i){
    let q = questions[index];

    if(i === q.correct){
        score++;
    }

    document.querySelectorAll(".option").forEach(btn => btn.onclick = null);

    document.getElementById("nextBtn").classList.remove("hide");
}

// NEXT QUESTION
function nextQuestion(){
    index++;

    if(index < questions.length){
        loadQuestion();
    } else {
        showResult();
    }
}

// RESULT
function showResult(){
    document.getElementById("quizBox").classList.add("hide");
    document.getElementById("resultBox").classList.remove("hide");

    document.getElementById("resultText").innerText =
        `You scored ${score} out of ${questions.length}`;
}

// REPLAY
function replay(){
    location.reload();
}
'''
HTMLCODE
'''
<!DOCTYPE html>
<html lang="en">
<head><link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Quiz App</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <!-- SUBJECT SELECTION -->
    <div class="subject-box" id="subjectBox">
        <h2>Select Subject</h2>
        <button onclick="startQuiz('html')">HTML</button>
        <button onclick="startQuiz('css')">CSS</button>
        <button onclick="startQuiz('java')">JavaScript</button>
    </div>

    <!-- QUIZ BOX -->
    <div class="quiz-box hide" id="quizBox">
        <h2 id="subjectTitle"></h2>

        <div class="timer">Time Left: <span id="time">10</span>s</div>

        <h3 id="questionText"></h3>

        <div id="options"></div>

        <button id="nextBtn" class="hide" onclick="nextQuestion()">Next</button>
    </div>

    <!-- RESULT BOX -->
    <div class="result-box hide" id="resultBox">
        <h2>Quiz Completed!</h2>
        <p id="resultText"></p>
        <button onclick="replay()">Replay</button>
    </div>
        
    <script src="script.js"></script>
</body>
</html>
'''
CSS CODE
'''
body{
    background: #0a7cff;
    font-family: Arial, sans-serif;
    text-align: center;
    padding: 20px;
}

.hide{
    display: none;
}

.subject-box, .quiz-box, .result-box{
    background: white;
    width: 90%;
    max-width: 400px;
    margin: auto;
    padding: 20px;
    border-radius: 15px;
    box-shadow: 0 0 15px rgba(0,0,0,0.3);
}

button{
    margin-top: 10px;
    padding: 10px 20px;
    border: none;
    background: #0a7cff;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    cursor: pointer;
}

button:hover{
    background: #005ec7;
}

.timer{
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 10px;
}

.option{
    background: #e6f0ff;
    padding: 12px;
    margin: 8px 0;
    border-radius: 10px;
    cursor: pointer;
}

.option:hover{
    background: #bad7ff;
}
'''
