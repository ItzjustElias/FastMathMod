<br>
<div align="center">
<img width="500" height="100" src="https://i.imgur.com/tPWHBJh.png">
</div>
<br>
<div align="center">
 <img src="https://img.shields.io/modrinth/dt/rIQr6J6I?logo=modrinth&color=coolgreen">
 <img src="https://img.shields.io/badge/environment-client%20%2B%20server-1976d2">
 <img src="https://img.shields.io/badge/modloader-Fabric-1976d2?color=beige">
</div>
<br>

Super Fast Math is a lightweight Fabric mod designed to optimize core mathematical operations and game logic inside Minecraft. Instead of relying solely on default implementations, this mod replaces several frequently used math functions and systems with high-performance alternatives.

### ⚡ What It Optimizes
- Faster sine & cosine via optimized lookup tables
- Hardware-accelerated square root (native SQRTSS instruction)
- Improved floor and clamp operations
- Faster atan2 for entity orientation*
- Optimized interpolation (lerp) using fused multiply-add
- BlockPos bit-packing for faster chunk coordinate encoding

### 📊 Benchmarks
Tested on a superflat world with 200 zombies pathfinding, active redstone, and `/gamerule randomTickSpeed 1000`. Tested with Spark.

| Metric | Vanilla | SuperFastMath | Improvement |
|--------|---------|---------------|-------------|
| TPS (1m) | 14.13 | 20.00 | **+41%** |
| TPS (5m) | 14.94 | 19.88 | **+33%** |
| MSPT median | 51.4ms | 43.4ms | **-8ms** |
| MSPT max spike | 202ms | 153ms | **-24%** |

> Tested on Java 25, i5-12400F, Minecraft 26.1.2 with Fabric

### 🚀 Why?
These optimizations affect:
- Entity movement & AI orientation
- Chunk loading and coordinate math
- Redstone and collision detection
- World math utilities

Both **client and server** benefit from this mod. Server operators running mob farms, or high entity counts will see the most improvement.

### 🧠 Technical Notes
- Patches `Mth`, `BlockPos` via Mixin
- Designed for Fabric
- Lightweight with zero configuration
- Works server-side and client-side
- Compatible with Sodium and other performance mods (for the most part, create an issue if this still errors)

### ⚠️ Notes
- *The `atan2` replacement has been reverted to exact math to prevent projectile angle errors

Super Fast Math keeps Minecraft's behavior intact while improving execution speed where it matters most.
