package spx.particles;

public abstract class ParticleBehavior {
	public int GetParticleCount() {
		return 10;
	}

	public abstract void Update(Particle2 particle);
}
