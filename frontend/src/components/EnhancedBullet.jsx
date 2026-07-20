function EnhancedBullet({ bulletPoint }) {
  if (!bulletPoint) {
    return null;
  }

  return (
    <section className="enhanced-result" aria-live="polite">
      <h2>Enhanced bullet point</h2>
      <p>{bulletPoint}</p>
    </section>
  );
}

export default EnhancedBullet;
