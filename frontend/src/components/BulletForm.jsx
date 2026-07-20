import { useState } from 'react';

function BulletForm({ onSubmit, loading }) {
  const [bulletPoint, setBulletPoint] = useState('');

  function handleSubmit(event) {
    event.preventDefault();

    if (!bulletPoint.trim()) {
      return;
    }

    onSubmit(bulletPoint.trim());
  }

  return (
    <form className="bullet-form" onSubmit={handleSubmit}>
      <label htmlFor="bulletPoint">Resume bullet point</label>
      <textarea
        id="bulletPoint"
        value={bulletPoint}
        onChange={(event) => setBulletPoint(event.target.value)}
        placeholder="Example: helped sales team make reports faster"
        rows="6"
      />
      <button type="submit" disabled={loading || !bulletPoint.trim()}>
        {loading ? 'Enhancing...' : 'Enhance bullet'}
      </button>
    </form>
  );
}

export default BulletForm;
