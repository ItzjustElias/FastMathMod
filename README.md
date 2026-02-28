<br>
<div align="center">
<img width="500" height="100" src="https://i.imgur.com/tPWHBJh.png">
</div>
<br>
<div align="center">
 <img src="https://img.shields.io/modrinth/dt/rIQr6J6I?logo=modrinth&color=coolgreen">
 <img src="https://img.shields.io/badge/environment-client-1976d2">
 <img src="https://img.shields.io/badge/modloader-Fabric-1976d2?color=beige">
</div>
<br>

Super Fast Math is a lightweight Fabric mod designed to optimize core mathematical operations inside Minecraft’s `MathHelper`.

Instead of relying solely on the default implementations, this mod replaces several frequently used math functions with high-performance alternatives powered by optimized lookup tables and fast approximations.

### ⚡ What It Optimizes
- Faster sine & cosine calculations
- Optimized square root using fast inverse square root
- Improved floor and clamp operations
- Faster atan2 approximation
- Optimized interpolation (lerp)
- Efficient Perlin fade function

### 🚀 Why?
These math functions are used constantly throughout:
- Entity movement & rotation
- AI orientation
- Noise generation
- World math utilities
- Rendering calculations

By reducing the computational overhead of these operations, Super Fast Math helps improve overall performance, especially in math-heavy scenarios.

### 🧠 Technical Notes
- Overwrites selected `MathHelper` methods using Mixin
- Designed for Fabric
- Lightweight with zero configuration
- Client-side focused optimization

Super Fast Math keeps Minecraft’s behavior intact while improving execution speed where it matters most.
