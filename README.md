# AI Resume Bullet Point Enhancer

A small full-stack application that rewrites rough resume bullet points into polished, professional versions using the OpenAI API.

## Project Structure

```text
AI Resume Bullet Point Enhancer/
├── backend/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/example/resumeenhancer/
│       │   ├── ResumeEnhancerApplication.java
│       │   ├── controller/ResumeController.java
│       │   ├── model/EnhanceRequest.java
│       │   ├── model/EnhanceResponse.java
│       │   └── service/ResumeEnhancementService.java
│       └── resources/application.properties
├── frontend/
│   ├── index.html
│   ├── package.json
│   └── src/
│       ├── main.jsx
│       ├── App.jsx
│       ├── styles.css
│       └── components/
│           ├── BulletForm.jsx
│           └── EnhancedBullet.jsx
└── README.md
```

## Backend

The backend exposes:

```http
POST http://localhost:8080/api/resume/enhance
Content-Type: application/json
```

Request body:

```json
{
  "bulletPoint": "helped sales team make reports faster"
}
```

Response body:

```json
{
  "enhancedBulletPoint": "Improved sales reporting efficiency by streamlining report preparation workflows for the sales team."
}
```

### Configure OpenAI

Set your OpenAI API key in `backend/src/main/resources/application.properties`:

```properties
openai.api.key=your-openai-api-key
```

Or keep the property as-is and set an environment variable:

```powershell
$env:OPENAI_API_KEY="your-openai-api-key"
```

## Run Locally

### Prerequisites

- Java 17 or newer
- Maven
- Node.js 18 or newer
- An OpenAI API key

### Start the Backend

```powershell
cd backend
mvn spring-boot:run
```

The backend runs at:

```text
http://localhost:8080
```

### Start the Frontend

Open a second terminal:

```powershell
cd frontend
npm install
npm run dev
```

The frontend runs at:

```text
http://localhost:5173
```

## Frontend API Call

The React app sends the bullet point to the backend with a `fetch` POST request:

```javascript
const response = await fetch('http://localhost:8080/api/resume/enhance', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({ bulletPoint })
});
```

The backend calls OpenAI and returns the enhanced bullet point to the UI.
