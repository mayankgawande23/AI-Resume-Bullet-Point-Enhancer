import { useState } from 'react';
import BulletForm from './components/BulletForm.jsx';
import EnhancedBullet from './components/EnhancedBullet.jsx';

function App() {
  const [enhancedBullet, setEnhancedBullet] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  async function handleEnhance(bulletPoint) {
    setLoading(true);
    setError('');
    setEnhancedBullet('');

    try {
      const response = await fetch('http://localhost:8080/api/resume/enhance', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ bulletPoint })
      });

      if (!response.ok) {
        throw new Error('Unable to enhance this bullet point.');
      }

      const data = await response.json();
      setEnhancedBullet(data.enhancedBulletPoint);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <main className="app-shell">
      <section className="workspace">
        <div className="header">
          <h1>AI Resume Bullet Point Enhancer</h1>
          <p>Turn a rough resume bullet into a clearer, stronger achievement statement.</p>
        </div>

        <BulletForm onSubmit={handleEnhance} loading={loading} />
        {error && <p className="error">{error}</p>}
        <EnhancedBullet bulletPoint={enhancedBullet} />
      </section>
    </main>
  );
}

export default App;
