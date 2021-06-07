<template>
  <Header />
  <main class="container mx-auto px-4 tracking-tighter">
    <slot />
  </main>
  <Footer />
</template>

<script>
import Header from "./Header.vue"
import Footer from "./Footer.vue"

export default {
  components: {
    Header,
    Footer,
  },
}
</script>