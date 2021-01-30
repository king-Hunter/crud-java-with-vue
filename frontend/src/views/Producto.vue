<template>
  <div class="producto">
  
    <ProductosComponent />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import ProductosComponent from '@/components/ProductosComponent.vue'; // @ is an alias to /src

@Component({
  components: {
    ProductosComponent
  },
})
export default class Home extends Vue {}
</script>
