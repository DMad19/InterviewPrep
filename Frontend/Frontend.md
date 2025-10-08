## Q1 What Are Semantic HTML Elements?
Semantic elements clearly convey their purpose both to developers and browsers. Instead of generic containers like <div> or <span>, semantic tags tell you what the content is.

**Semantic HTML Elements**

| Element       | Purpose                                      |
|---------------|----------------------------------------------|
| `<header>`    | Introductory content or navigation           |
| `<nav>`       | Navigation links                             |
| `<main>`      | Primary content of the page                  |
| `<section>`   | Thematic grouping of content                 |
| `<article>`   | Self-contained content (e.g., blog post)     |
| `<aside>`     | Sidebar or tangential content                |
| `<footer>`    | Closing content, copyright, links            |
| `<figure>`    | Media with caption                           |
| `<figcaption>`| Caption for a figure                         |


🎯 Why Are They Important?
1. Accessibility

2. SEO (Search Engine Optimization)

3. Maintainability

4. Consistency Across Devices

## Q2 Difference between Div and Section

| Feature          | `<div>`                 | `<section>`                                        |
| ---------------- | ----------------------- | -------------------------------------------------- |
| Meaning          | None (non-semantic)     | Thematic grouping (semantic)                       |
| Accessibility    | Neutral                 | Recognized by assistive tech as a document section |
| SEO impact       | None                    | Improves page structure for search crawlers        |
| When to use      | For layout/styling only | When grouping related content with a heading       |
| Requires heading | ❌ Not required          | ✅ Recommended (for clarity)                        |


## Q3 How does the browser render HTML behind the scenes (DOM construction, reflow, repaint)?

🧱 1. HTML Parsing → DOM Construction  
🎨 2. CSS Parsing → CSSOM Construction  
🧮 3. Render Tree Construction  
📐 4. Layout (Reflow)  
🎨 5. Painting  
🖼️ 6. Compositing → Display  

## Q4 Difference between class and id attributes

| Feature      | `id`                         | `class`                                                         |
| ------------ | ---------------------------- | --------------------------------------------------------------- |
| Purpose      | Uniquely identify an element | Group similar elements                                          |
| Uniqueness   | Must be unique               | Can repeat                                                      |
| CSS Selector | `#idName`                    | `.className`                                                    |
| Specificity  | Higher                       | Lower                                                           |
| Reusability  | ❌                            | ✅                                                               |
| JS Access    | `getElementById('id')`       | `getElementsByClassName('class')`, `querySelectorAll('.class')` |

## Q5 Explain Accessibility (a11y). What are ARIA roles?

Accessibility (a11y) means designing and building websites that can be used by everyone, including users with:

    Visual impairments (e.g. blind or colorblind)

    Hearing impairments

    Motor disabilities

    Cognitive difficulties

The term a11y comes from:

    “accessibility” → 11 letters between “a” and “y”.

#### Common ARIA attributes

| Attribute                    | Purpose                           | Example                                              |
| ---------------------------- | --------------------------------- | ---------------------------------------------------- |
| `role`                       | Defines what the element *is*     | `<div role="button">Click</div>`                     |
| `aria-label`                 | Gives an accessible name          | `<button aria-label="Close menu">X</button>`         |
| `aria-hidden="true"`         | Hides element from screen readers | `<span aria-hidden="true">★</span>`                  |
| `aria-expanded="true/false"` | Indicates dropdown/toggle state   | `<button aria-expanded="true">Menu</button>`         |
| `aria-live`                  | Announces dynamic changes         | `<div aria-live="polite">New message received</div>` |

Accessibility means ensuring all users can interact with my web app — including screen reader and keyboard users. I follow semantic HTML first, ensure focus states and contrast, and use ARIA roles only when native semantics aren’t enough.


## Q6 How do you optimize HTML for SEO (Search Engine Optimization)? explain in interview perspective

“To optimize HTML for SEO, I focus on making the markup both machine-readable for search engines and accessible for users. That starts with using semantic HTML to convey meaning and structure.”

✅ 1. Semantic HTML for Structure & Clarity

✅ 2. Title & Meta Tags for Discoverability

✅ 3. Heading Tags for Content Hierarchy

✅ 4. Alt Text for Images

✅ 5. Clean URLs and Internal Linking

✅ 6. Mobile Optimization

✅ 7. Structured Data with JSON-LD

✅ 8. Performance & Accessibility

## Q7 Difference between script, script async, script defer

| Attribute                  | `<script>`             | `<script async>`         | `<script defer>` |
| -------------------------- | ---------------------- | ------------------------ | ---------------- |
| Blocks HTML parsing?       | ✅ Yes                  | ⚠️ Only during execution | ❌ No             |
| Downloads in parallel?     | ❌ No                   | ✅ Yes                    | ✅ Yes            |
| Execution order preserved? | ✅ Yes                  | ❌ No                     | ✅ Yes            |
| Executes after parsing?    | ❌ No                   | ❌ No                     | ✅ Yes            |
| Typical use case           | Critical inline script | Analytics / Ads          | Main app bundles |


## Q8 Explain static, relative, absolute, fixed ans sticky positions

| Property   | In Flow?          | Positioned Relative To      | Moves on Scroll? | Typical Use                           |
| ---------- | ----------------- | --------------------------- | ---------------- | ------------------------------------- |
| `static`   | ✅ Yes             | —                           | ✅ Yes            | Default                               |
| `relative` | ✅ Yes             | Itself                      | ✅ Yes            | Minor offset / reference for absolute |
| `absolute` | ❌ No              | Nearest positioned ancestor | ✅ Yes            | Tooltip, dropdown, modal              |
| `fixed`    | ❌ No              | Viewport                    | ❌ No             | Navbar, floating button               |
| `sticky`   | ✅ until threshold | Scroll container            | ✅ / ❌ Hybrid     | Sticky header or sidebar              |

## Q9 Explain Flex vs Grid

| Feature         | Flexbox                      | Grid                        |
| --------------- | ---------------------------- | --------------------------- |
| Dimension       | 1D                           | 2D                          |
| Alignment       | Easier for small UI sections | Easier for full layouts     |
| Browser Support | Excellent                    | Very good (modern browsers) |
| Nesting         | Often used inside grids      | Usually top-level layout    |

## Q10 What is z-index

z-index is like layer ordering, but it only matters within its stacking context. Once a new stacking context is created, elements outside that context can’t be overlapped by children inside it, regardless of z-index value.